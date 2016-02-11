SELECT *
FROM Products
WHERE (city!='Dallas' and city!='Duluth')
AND priceUSD >= 1.00
