import pandas as pd

def total_time(employees: pd.DataFrame) -> pd.DataFrame:
    employees["time"] = employees["out_time"] - employees["in_time"]

    result = employees.groupby(
        ["event_day", "emp_id"],
        as_index=False
    )["time"].sum()

    result = result.rename(columns={
        "event_day": "day",
        "time": "total_time"
    })
    return result