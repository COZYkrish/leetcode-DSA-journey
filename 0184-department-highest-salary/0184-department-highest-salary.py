import pandas as pd
def department_highest_salary(employee: pd.DataFrame, department: pd.DataFrame) -> pd.DataFrame:
    employee["max_salary"] = employee.groupby("departmentId")["salary"].transform("max")
    result = employee[employee["salary"] == employee["max_salary"]]
    result = result.merge(
        department,
        left_on="departmentId",
        right_on="id"
    )
    return result.rename(columns={
        "name_y": "Department",
        "name_x": "Employee",
        "salary": "Salary"
    })[["Department", "Employee", "Salary"]]