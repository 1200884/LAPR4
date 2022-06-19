grammar LabeledExpr2;
survey : title NEXT id NEXT list_of_clients #handleClients;
list_of_clients: client+;
client : '*' number '*' NEXT list_of_sections;
list_of_sections: section+;
section: '[' title NEXT id NEXT content ']' NEXT;
content: (question_struct+)|'No answers.';
question_struct : '>' NEXT 'Question' NEXT id type NEXT;

title:NEXT (number|word)+;
id: (number|word)+ PONTUATION;

type:free_text|numeric|single_choice|multiple_choice|sorting_options|scaling_options;

free_text: '(Free Text)' (NEXT sentence)+;
numeric:'(Numeric)' number;
single_choice:'(Single Choice)' LETTER;
multiple_choice:'(Multiple Choice)' word;
sorting_options:'(Sorting Options)' word;
scaling_options:'(Scaling Options)' (NEXT LETTER '-' number)+;

sentence: (word|number) (PONTUATION? NEXT (word|number))+ dot_mark;
word: LETTER+;
dot_mark: EXCLAMATION|INTERROGATION|DOT;
number:DIGIT+;

EXCLAMATION: '!' ;
INTERROGATION: '?' ;
DOT:'.';

DIGIT: [0-9];
LETTER: [A-Z]|[a-z];
PONTUATION: ',' | ':';
NEXT: [ \t\r\n]+;
DEPENDENT: '<';
