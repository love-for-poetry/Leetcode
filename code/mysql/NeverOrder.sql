/**
183. 从不订购的客户
某网站包含两个表，Customers 表和 Orders 表。编写一个 SQL 查询，找出所有从不订购任何东西的客户。
Customers 表：
+----+-------+
| Id | Name  |
+----+-------+
| 1  | Joe   |
| 2  | Henry |
| 3  | Sam   |
| 4  | Max   |
+----+-------+
Orders 表：

+----+------------+
| Id | CustomerId |
+----+------------+
| 1  | 3          |
| 2  | 1          |
+----+------------+
例如给定上述表格，你的查询应返回：
+-----------+
| Customers |
+-----------+
| Henry     |
| Max       |
+-----------+
 */

SELECT c.`Name` as Customers FROM  `Customers` c LEFT JOIN `Orders` o ON c.Id=o.CustomerId WHERE o.Id IS NULL