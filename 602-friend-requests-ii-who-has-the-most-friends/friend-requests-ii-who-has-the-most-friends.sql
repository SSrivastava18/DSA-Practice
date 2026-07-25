# Write your MySQL query statement below
WITH FriendCount AS (
    SELECT id, COUNT(*) AS num
    FROM (
        SELECT requester_id AS id
        FROM RequestAccepted

        UNION ALL

        SELECT accepter_id
        FROM RequestAccepted
    ) t
    GROUP BY id
)

SELECT id, num
FROM FriendCount
WHERE num = (
    SELECT MAX(num)
    FROM FriendCount
);