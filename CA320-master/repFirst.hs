repFirst :: Eq a => a -> a -> [a] -> [a]
repFirst a c b
   | length b == 0 = []
   | head b == a = c:tail b
   | length b == 1 && head b /= a = b
   | length b == 1 = []
   | otherwise = head b:repFirst a c (tail b)