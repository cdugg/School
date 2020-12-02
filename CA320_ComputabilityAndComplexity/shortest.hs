shortest :: [[a]] -> [a]
shortest a
   | length a == 0 = []
   | length a == 1 = head a
   | length(head a) > length(head(tail a)) = shortest(tail a)
   | otherwise = shortest((head a):tail(tail a))