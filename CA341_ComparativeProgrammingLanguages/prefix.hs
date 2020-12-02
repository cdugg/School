prefix :: [[Char]] -> [Char]
prefix [] = ""
prefix l = foldl1 prefix1 l

prefix1 :: [Char] -> [Char] -> [Char]
prefix1 _ [] = []
prefix1 [] _ = []
prefix1 (x:xs) (y:ys)
   | x == y = x : prefix1 xs ys
   | otherwise = []

--prefix :: [String] -> String
--prefix wordz
--   | length wordz == 1 = head wordz
--   | otherwise = prefix2 (head wordz) (resize (tail wordz) (length (head wordz))) (tail wordz)

--prefix2 :: String -> [String] -> [String] -> String
--prefix2 word [] _ = word
--prefix2 "" _ _ = ""
--prefix2 word (x:xs) l
--   | word == x = prefix2 word xs l
--   | otherwise = prefix2 (init word) (resize l (length (init word))) l

--resize :: [String] -> Int -> [String]
--resize l n
--   | length l == 1 = [take n (head l)]
--   | length (head l) > n = [take n (head l)] ++ resize (tail l) n
--   | otherwise = [head l] ++ resize (tail l) n