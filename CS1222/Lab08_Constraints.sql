/*
George Leal
Daniel Ng

Lab 08: Constraints
*/
ALTER TABLE SalesPeople ADD PRIMARY KEY (SalesID);

-- Q1: ContractID is the primary key and the default value of SalesID is 1.
ALTER TABLE Contracts
ADD PRIMARY KEY (ContractID);

ALTER TABLE Contracts
ALTER COLUMN SalesID SET DEFAULT 1;

-- Q2: Create a foreign key constraint to enforce that SalesID of the Contracts table refers to SalesID of the SalesPeople table.
ALTER TABLE Contracts
ADD CONSTRAINT fk_Contracts_SalesID
FOREIGN KEY (SalesID)
REFERENCES SalesPeople (SalesID);

-- Q3: Create a constraint so that the combination of ContractDate and ExpirationDate is unique.
ALTER TABLE Contracts
ADD CONSTRAINT un_ContractDate_ExpirationDate
UNIQUE(ContractDate, ExpirationDate);

-- Q4: Drop the primary key created in Q1.
ALTER TABLE Contracts
DROP PRIMARY KEY;