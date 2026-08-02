import pandas as pd
def nth_highest_salary(employee: pd.DataFrame, N: int) -> pd.DataFrame:
    if N <= 0:
        return pd.DataFrame({f"getNthHighestSalary({N})": [None]})
    salaries = (
        employee["salary"]
        .drop_duplicates()
        .sort_values(ascending=False)
        .reset_index(drop=True)
    )
    if N > len(salaries):
        return pd.DataFrame({f"getNthHighestSalary({N})": [None]})
    return pd.DataFrame({f"getNthHighestSalary({N})": [salaries.iloc[N - 1]]})