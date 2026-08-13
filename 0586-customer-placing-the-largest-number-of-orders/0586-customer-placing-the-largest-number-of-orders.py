import pandas as pd
def largest_orders(orders: pd.DataFrame) -> pd.DataFrame:
  if orders.empty:
    return pd.DataFrame({"customer_number": []})
  top_customer = orders["customer_number"].mode()[0]

  return pd.DataFrame({"customer_number": [top_customer]})