repAll :: Eq a => a -> a -> [a] -> [a]
repAll a c b
   | length b == 0 = []
   | head b == a = c:repAll a c (tail b)
   | length b == 1 && head b /= a = b
   | length b == 1 = []
   | otherwise = head b:repAll a c (tail b)