-- ============================================
-- Exercise 4 : Functions
-- ============================================

-- ============================================
-- Scenario 1
-- Calculate Customer Age
-- ============================================

CREATE OR REPLACE FUNCTION CalculateAge
(
    p_DOB DATE
)
RETURN NUMBER
IS
    v_Age NUMBER;
BEGIN

    v_Age := FLOOR(MONTHS_BETWEEN(SYSDATE, p_DOB) / 12);

    RETURN v_Age;

END;
/

-- ============================================
-- Scenario 2
-- Calculate Monthly Loan Installment
-- ============================================

CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment
(
    p_LoanAmount NUMBER,
    p_InterestRate NUMBER,
    p_Years NUMBER
)
RETURN NUMBER
IS
    v_MonthlyInstallment NUMBER;
BEGIN

    v_MonthlyInstallment :=
    (p_LoanAmount +
    (p_LoanAmount * p_InterestRate * p_Years / 100))
    / (p_Years * 12);

    RETURN v_MonthlyInstallment;

END;
/

-- ============================================
-- Scenario 3
-- Check Sufficient Balance
-- ============================================

CREATE OR REPLACE FUNCTION HasSufficientBalance
(
    p_AccountID NUMBER,
    p_Amount NUMBER
)
RETURN BOOLEAN
IS
    v_Balance NUMBER;
BEGIN

    SELECT Balance
    INTO v_Balance
    FROM Accounts
    WHERE AccountID = p_AccountID;

    IF v_Balance >= p_Amount THEN
        RETURN TRUE;
    ELSE
        RETURN FALSE;
    END IF;

EXCEPTION

    WHEN NO_DATA_FOUND THEN
        RETURN FALSE;

END;
/