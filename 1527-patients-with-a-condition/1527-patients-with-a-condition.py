import pandas as pd
def find_patients(patients: pd.DataFrame) -> pd.DataFrame:
    pattern = r'(^| )DIAB1\w*'
    return patients[patients["conditions"].str.contains(pattern, regex=True, na=False)]