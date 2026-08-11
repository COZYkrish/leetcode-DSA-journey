import pandas as pd

def find_classes(courses: pd.dataFrame) -> pd.DataFrame:
    result = courses.groupby('class')['student'].count().reset_index()
    result = result[result['student'] >= 5]
    return result[['class']]