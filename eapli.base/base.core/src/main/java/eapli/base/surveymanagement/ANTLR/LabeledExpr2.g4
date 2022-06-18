grammar LabeledExpr2;
survey : title NEXT id NEXT '-----------------------------------------------------' NEXT list_of_clients final_message;
list_of_clients: client+;
client : '*' title PONTUATION NEXT word NEXT number NEXT '*' NEXT list_of_sections;
list_of_sections: section+;
section: '[' title NEXT id NEXT obligatoriness NEXT (content|'No answers.') ']' NEXT #handleSection;
content: question_struct+;
question_struct : '>' NEXT id NEXT type NEXT;

title:NEXT (number|word)+ #printTitle;
id: (number|word)+ PONTUATION #printId;
final_message:text;

type:repeatability;
repeatability: repeatable|non_repeatable;
repeatable:free_text|numeric|single_choice_input|multiple_choice_input|single_choice|multiple_choice;
non_repeatable:sorting_options|scaling_options;
obligatoriness: mandatory|optional|cd;

mandatory:MANDATORY;
optional:OPTIONAL;
cd:CD;

free_text: '(Free Text)' (NEXT sentence)+;
numeric:'(Numeric)' NEXT number;
single_choice:'(Single Choice)' NEXT LETTER;
single_choice_input:'(Single Choice with input)' (NEXT LETTER)|(NEXT LETTER NEXT sentence);
multiple_choice:'(Multiple Choice)' NEXT word;
multiple_choice_input:'(Multiple Choice with input)' (NEXT word)|(NEXT word NEXT sentence) ;
sorting_options:'(Sorting Options)' NEXT word;
scaling_options:'(Scaling Options)' (NEXT LETTER '-' number)+;

text: '"' sentence (NEXT sentence)+ '"';
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

MANDATORY:'-----Mandatory';
OPTIONAL:'-----Optional';
CD:'-----Condition dependent';