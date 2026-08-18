import pandas as pd
def sales_person(sales_person: pd.DataFrame, company: pd.DataFrame, orders: pd.DataFrame) -> pd.DataFrame:
    df = orders.merge(company, on='com_id')
    red_sales_ids = df[df['name'] == 'RED']['sales_id']
    result = sales_person[~sales_person['sales_id'].isin(red_sales_ids)]
    return result[['name']]