prefix1("", _, "").
prefix1(_, "", "").
prefix1([X | XS], [X | YS], [X |ZS]) :- prefix1(XS, YS, ZS).
prefix1([X | _], [X | _], []).
prefix1([X | _], [X1 | _], []) :- dif(X, X1).

prefix([], Ans) :- prefix1("", "", Ans).
prefix([W], Ans) :- prefix1(W, W, Ans).
prefix([W1, W2 | L], Ans) :- prefix1(W1, W2, Ans), prefix([W2 | L], Ans).
