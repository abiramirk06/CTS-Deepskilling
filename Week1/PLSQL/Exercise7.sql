-- ============================================
-- Exercise 7 : Packages
-- ============================================

-- ============================================
-- Package 1 : CustomerManagement
-- ============================================

CREATE OR REPLACE PACKAGE CustomerManagement AS

    PROCEDURE AddCustomer(
        p_CustomerID NUMBER,
        p_Name VARCHAR2,
        p_DOB DATE,
        p_Balance NUMBER
    );

    PROCEDURE UpdateCustomer(
        p_CustomerID NUMBER,
        p_Name VARCHAR2
    );

    FUNCTION GetCustomerBalance(
        p_CustomerID NUMBER
    ) RETURN NUMBER;

END CustomerManagement;
/

CREATE OR REPLACE PACKAGE BODY CustomerManagement AS

    PROCEDURE AddCustomer(
        p_CustomerID NUMBER,
        p_Name VARCHAR2,
        p_DOB DATE,
        p_Balance NUMBER
    )
    IS
    BEGIN
        INSERT INTO Customers
        VALUES
        (
            p_CustomerID,
            p_Name,
            p_DOB,
            p_Balance,
            SYSDATE
        );
    END;

    PROCEDURE UpdateCustomer(
        p_CustomerID NUMBER,
        p_Name VARCHAR2
    )
    IS
    BEGIN
        UPDATE Customers
        SET Name = p_Name
        WHERE CustomerID = p_CustomerID;
    END;

    FUNCTION GetCustomerBalance(
        p_CustomerID NUMBER
    )
    RETURN NUMBER
    IS
        v_Balance NUMBER;
    BEGIN
        SELECT Balance
        INTO v_Balance
        FROM Customers
        WHERE CustomerID = p_CustomerID;

        RETURN v_Balance;
    END;

END CustomerManagement;
/

-- ============================================
-- Package 2 : EmployeeManagement
-- ============================================

CREATE OR REPLACE PACKAGE EmployeeManagement AS

    PROCEDURE HireEmployee(
        p_ID NUMBER,
        p_Name VARCHAR2,
        p_Position VARCHAR2,
        p_Salary NUMBER,
        p_Department VARCHAR2,
        p_HireDate DATE
    );

    PROCEDURE UpdateEmployee(
        p_ID NUMBER,
        p_Salary NUMBER
    );

    FUNCTION AnnualSalary(
        p_ID NUMBER
    ) RETURN NUMBER;

END EmployeeManagement;
/

CREATE OR REPLACE PACKAGE BODY EmployeeManagement AS

    PROCEDURE HireEmployee(
        p_ID NUMBER,
        p_Name VARCHAR2,
        p_Position VARCHAR2,
        p_Salary NUMBER,
        p_Department VARCHAR2,
        p_HireDate DATE
    )
    IS
    BEGIN
        INSERT INTO Employees
        VALUES
        (
            p_ID,
            p_Name,
            p_Position,
            p_Salary,
            p_Department,
            p_HireDate
        );
    END;

    PROCEDURE UpdateEmployee(
        p_ID NUMBER,
        p_Salary NUMBER
    )
    IS
    BEGIN
        UPDATE Employees
        SET Salary = p_Salary
        WHERE EmployeeID = p_ID;
    END;

    FUNCTION AnnualSalary(
        p_ID NUMBER
    )
    RETURN NUMBER
    IS
        v_Salary NUMBER;
    BEGIN
        SELECT Salary
        INTO v_Salary
        FROM Employees
        WHERE EmployeeID = p_ID;

        RETURN v_Salary * 12;
    END;

END EmployeeManagement;
/

-- ============================================
-- Package 3 : AccountOperations
-- ============================================

CREATE OR REPLACE PACKAGE AccountOperations AS

    PROCEDURE OpenAccount(
        p_AccountID NUMBER,
        p_CustomerID NUMBER,
        p_Type VARCHAR2,
        p_Balance NUMBER
    );

    PROCEDURE CloseAccount(
        p_AccountID NUMBER
    );

    FUNCTION TotalBalance(
        p_CustomerID NUMBER
    ) RETURN NUMBER;

END AccountOperations;
/

CREATE OR REPLACE PACKAGE BODY AccountOperations AS

    PROCEDURE OpenAccount(
        p_AccountID NUMBER,
        p_CustomerID NUMBER,
        p_Type VARCHAR2,
        p_Balance NUMBER
    )
    IS
    BEGIN
        INSERT INTO Accounts
        VALUES
        (
            p_AccountID,
            p_CustomerID,
            p_Type,
            p_Balance,
            SYSDATE
        );
    END;

    PROCEDURE CloseAccount(
        p_AccountID NUMBER
    )
    IS
    BEGIN
        DELETE FROM Accounts
        WHERE AccountID = p_AccountID;
    END;

    FUNCTION TotalBalance(
        p_CustomerID NUMBER
    )
    RETURN NUMBER
    IS
        v_Total NUMBER;
    BEGIN
        SELECT SUM(Balance)
        INTO v_Total
        FROM Accounts
        WHERE CustomerID = p_CustomerID;

        RETURN NVL(v_Total,0);
    END;

END AccountOperations;
/