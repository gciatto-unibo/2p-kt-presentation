?- type('java.lang.StringBuilder', Type), 
   register(Type, string_builder), 
   new_object($string_builder, SB), 
   SB.append(hello), 
   X := SB.toString, 
   $stdout.println(X),
   unregister(string_builder).

% yes.
%    Type = '<type:java.lang.StringBuilder>'
%    SB = '<object:java.lang.StringBuilder#624a24f6>'
%    X = hello