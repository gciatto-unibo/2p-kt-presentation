?- type('java.lang.StringBuilder', SB), new_object(SB, S), 
   S.append('hello world'), % atom converted into string
   S.replace(0, 1, 'H'), % integers converted into int
   X := S.toString, % string converted back into atom
   atom(X).

% yes.
%    SB = '<type:java.lang.StringBuilder>'
%    S = '<object:java.lang.StringBuilder#4bbb49b0>'
%    X = 'Hello world'