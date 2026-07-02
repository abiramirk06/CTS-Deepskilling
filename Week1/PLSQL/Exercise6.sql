-- ============================================
-- Exercise 6 : Cursors
-- ============================================

-- ============================================
-- Scenario 1
-- Generate Monthly Statements
-- ============================================

DECLARE

    CURSOR GenerateMonthlyStatements IS
    SELECT
        c.Name,
        t.TransactionID,
        t.TransactionDate,
        t.Amount,
        t.TransactionType
    FROM Customers c
    JOIN Accounts a
    ON c.CustomerID = a.CustomerID
    JOIN Transactions t
    ON a.AccountID = t.AccountID
    WHERE TO_CHAR(t.TransactionDate,'MMYYYY')
          = TO_CHAR(SYSDATE,'MMYYYY');

BEGIN

    FOR rec IN GenerateMonthlyStatements LOOP

        DBMS_OUTPUT.PUT_LINE(
            'Customer : ' || rec.Name ||
            ' | Transaction ID : ' || rec.TransactionID ||
            ' | Amount : ' || rec.Amount ||
            ' | Type : ' || rec.TransactionType
        );

    END LOOP;

END;
/

-- ============================================
-- Scenario 2
-- Apply Annual Maintenance Fee
-- ============================================

DECLARE

    CURSOR ApplyAnnualFee IS
    SELECT AccountID, Balance
    FROM Accounts;

BEGIN

    FOR acc IN ApplyAnnualFee LOOP

        UPDATE Accounts
        SET Balance = Balance - 100
        WHERE AccountID = acc.AccountID;

    END LOOP;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Annual maintenance fee applied.');

END;
/

-- ============================================
-- Scenario 3
-- Update Loan Interest Rates
-- ============================================

DECLARE

    CURSOR UpdateLoanInterestRates IS
    SELECT LoanID, InterestRate
    FROM Loans;

BEGIN

    FOR loan IN UpdateLoanInterestRates LOOP

        UPDATE Loans
        SET InterestRate = InterestRate + 0.5
        WHERE LoanID = loan.LoanID;

    END LOOP;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Loan interest rates updated.');

END;
/