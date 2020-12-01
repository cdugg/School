delAll :: Eq a => a -> [a] -> [a]
delAll a b
   | length b == 0 = []
   | head b == a = delAll a (tail b)
   | length b == 1 && head b /= a = b
   | length b == 1 = []
   | otherwise = head b:delAll a (tail b)