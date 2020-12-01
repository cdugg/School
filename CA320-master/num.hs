num :: Eq a => a -> [a] -> Int
num a b
   | b == [] = 0
   | head b == a = 1 + num a (tail b)
   | otherwise = num a (tail b)