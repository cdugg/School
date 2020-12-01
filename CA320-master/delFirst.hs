delFirst :: Eq a => a -> [a] -> [a]
delFirst a b
   | length b == 0 = []
   | head b == a = tail b
   | length b == 1 && head b /= a = b
   | length b == 1 = []
   | otherwise = head b:delFirst a (tail b)