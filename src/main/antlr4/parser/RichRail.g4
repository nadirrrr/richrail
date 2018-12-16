grammar RichRail;

// Rules
command         : newcommand | delcommand | remcommand;
newcommand      : newtraincommand | newwagoncommand | newlocomotivecommand;
newtraincommand : 'new' 'train' ID; // nieuwe trein
newwagoncommand : 'new' 'wagon' ID; // nieuwe wagon
newlocomotivecommand : 'new' 'locomotive' ID; // nieuwe wagon
delcommand      : 'delete' 'train' ID; // trein compleet verwijderen
remcommand      : 'remove' 'component' 'from' ID; // rolling components verwijderen

// Tokens
ID          : ('a'..'z')('a'..'z')('0'..'9')*;
NUMBER      : ('0'..'9')+;
WHITESPACE  : [ \t\r\n\u000C] -> skip;
