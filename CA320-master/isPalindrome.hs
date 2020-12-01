isPalindrome :: Eq a => [a] -> Bool
isPalindrome s
   | length s <= 1 = True
   | head s == last s = isPalindrome(tail(reverse(tail s)))
   | otherwise = False