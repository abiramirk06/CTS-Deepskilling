-- ============================================
-- Exercise 1 : Control Structures
-- ============================================

-- ============================================
-- Scenario 1
-- Apply 1% discount to loan interest rate for
-- customers above 60 years of age
-- ============================================

DECLARE
    CURSOR c_customers IS
        SELECT CustomerID, DOB
        FROM Customers;

    v_age NUMBER;
BEGIN

    FOR cust IN c_customers LOOP

        v_age := FLOOR(MONTHS_BETWEEN(SYSDATE, cust.DOB) / 12);

        IF v_age > 60 THEN

            UPDATE Loans
            SET InterestRate = InterestRate - 1
            WHERE CustomerID = cust.CustomerID;

        END IF;

    END LOOP;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Interest rates updated successfully.');

END;
/

-- ============================================
-- Scenario 2
-- Set VIP flag for customers having
-- balance greater than 10000
-- ============================================

ALTER TABLE Customers
ADD IsVIP VARCHAR2(5);

BEGIN

    FOR cust IN
    (
        SELECT CustomerID, Balance
        FROM Customers
    )
    LOOP

        IF cust.Balance > 10000 THEN

            UPDATE Customers
            SET IsVIP='TRUE'
            WHERE CustomerID=cust.CustomerID;

        ELSE

            UPDATE Customers
            SET IsVIP='FALSE'
            WHERE CustomerID=cust.CustomerID;

        END IF;

    END LOOP;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('VIP status updated.');

END;
/

-- ============================================
-- Scenario 3
-- Print reminder for loans due
-- within the next 30 days
-- ============================================

BEGIN

    FOR loan IN
    (
        SELECT
            c.Name,
            l.LoanID,
            l.EndDate
        FROM Customers c
        JOIN Loans l
        ON c.CustomerID=l.CustomerID
        WHERE l.EndDate
        BETWEEN SYSDATE
        AND SYSDATE+30
    )
    LOOP

        DBMS_OUTPUT.PUT_LINE(
            'Reminder : Dear '
            || loan.Name ||
            ', Your Loan ID '
            || loan.LoanID ||
            ' is due on '
            || loan.EndDate
        );

    END LOOP;

END;
/