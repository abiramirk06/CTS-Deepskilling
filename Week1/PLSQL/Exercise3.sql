-- ============================================
-- Exercise 3 : Stored Procedures
-- ============================================

-- ============================================
-- Scenario 1
-- Process Monthly Interest for Savings Accounts
-- ============================================

CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest
IS
BEGIN

    UPDATE Accounts
    SET Balance = Balance + (Balance * 0.01)
    WHERE AccountType = 'Savings';

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Monthly interest processed successfully.');

END;
/

-- ============================================
-- Scenario 2
-- Update Employee Bonus
-- ============================================

CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus
(
    p_Department VARCHAR2,
    p_BonusPercentage NUMBER
)
IS
BEGIN

    UPDATE Employees
    SET Salary = Salary + (Salary * p_BonusPercentage / 100)
    WHERE Department = p_Department;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Employee bonus updated successfully.');

END;
/

-- ============================================
-- Scenario 3
-- Transfer Funds
-- ============================================

CREATE OR REPLACE PROCEDURE TransferFunds
(
    p_FromAccount NUMBER,
    p_ToAccount NUMBER,
    p_Amount NUMBER
)
IS
    v_Balance NUMBER;
BEGIN

    SELECT Balance
    INTO v_Balance
    FROM Accounts
    WHERE AccountID = p_FromAccount;

    IF v_Balance >= p_Amount THEN

        UPDATE Accounts
        SET Balance = Balance - p_Amount
        WHERE AccountID = p_FromAccount;

        UPDATE Accounts
        SET Balance = Balance + p_Amount
        WHERE AccountID = p_ToAccount;

        COMMIT;

        DBMS_OUTPUT.PUT_LINE('Fund transfer successful.');

    ELSE

        DBMS_OUTPUT.PUT_LINE('Insufficient Balance.');

    END IF;

END;
/