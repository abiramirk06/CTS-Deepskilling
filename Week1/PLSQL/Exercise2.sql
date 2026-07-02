-- ============================================
-- Exercise 2 : Error Handling
-- ============================================

-- ============================================
-- Scenario 1
-- Safe Transfer Funds
-- ============================================

CREATE OR REPLACE PROCEDURE SafeTransferFunds
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

    IF v_Balance < p_Amount THEN
        RAISE_APPLICATION_ERROR(-20001, 'Insufficient Balance');
    END IF;

    UPDATE Accounts
    SET Balance = Balance - p_Amount
    WHERE AccountID = p_FromAccount;

    UPDATE Accounts
    SET Balance = Balance + p_Amount
    WHERE AccountID = p_ToAccount;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Funds transferred successfully.');

EXCEPTION

    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE(SQLERRM);

END;
/

-- ============================================
-- Scenario 2
-- Update Employee Salary
-- ============================================

CREATE OR REPLACE PROCEDURE UpdateSalary
(
    p_EmployeeID NUMBER,
    p_Percentage NUMBER
)
IS
BEGIN

    UPDATE Employees
    SET Salary = Salary + (Salary * p_Percentage / 100)
    WHERE EmployeeID = p_EmployeeID;

    IF SQL%ROWCOUNT = 0 THEN
        RAISE_APPLICATION_ERROR(-20002, 'Employee ID does not exist');
    END IF;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Salary updated successfully.');

EXCEPTION

    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE(SQLERRM);

END;
/

-- ============================================
-- Scenario 3
-- Add New Customer
-- ============================================

CREATE OR REPLACE PROCEDURE AddNewCustomer
(
    p_CustomerID NUMBER,
    p_Name VARCHAR2,
    p_DOB DATE,
    p_Balance NUMBER
)
IS
BEGIN

    INSERT INTO Customers
    (
        CustomerID,
        Name,
        DOB,
        Balance,
        LastModified
    )
    VALUES
    (
        p_CustomerID,
        p_Name,
        p_DOB,
        p_Balance,
        SYSDATE
    );

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Customer added successfully.');

EXCEPTION

    WHEN DUP_VAL_ON_INDEX THEN
        DBMS_OUTPUT.PUT_LINE('Customer ID already exists.');

    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE(SQLERRM);

END;
/