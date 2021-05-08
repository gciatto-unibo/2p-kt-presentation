?- type('java.lang.StringBuilder', StringBuilder), 
   new_object(StringBuilder, SB), 
   X is 1 / 3,
   SB.append(X as $double), 
   SB.append('|'),
   SB.append(X as $float), 
   S := SB.toString.

% yes.
%    StringBuilder = '<type:java.lang.StringBuilder>'
%    SB = '<object:java.lang.StringBuilder#4aedaf61>'
%    X = 0.333333333
%    S = '0.333333333|0.33333334'