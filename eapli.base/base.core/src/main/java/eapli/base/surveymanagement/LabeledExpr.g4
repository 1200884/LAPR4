grammar LabeledExpr;
questionnaire : title NEXT id NEXT welcome_message NEXT '-----------------------------------------------------' NEXT list_of_sections final_message;
list_of_sections: section+;
section : '[' title NEXT id NEXT section_description NEXT obligatoriness NEXT content ']' NEXT;
content: question_struct+;
question_struct : '>' id NEXT instruction NEXT type NEXT;

title:NEXT (number|word)+;
id: (number|word)+ PONTUATION;
welcome_message: text;
section_description: sentence;

instruction: sentence;
final_message: text;

type:repeatability;
repeatability: repeatable|non_repeatable;
repeatable:free_text|numeric|single_choice_input|multiple_choice_input;
non_repeatable:single_choice|multiple_choice|sorting_options|scaling_options;
obligatoriness: mandatory|optional|cd;

mandatory:MANDATORY;
optional:OPTIONAL;
cd:CD NEXT id NEXT id NEXT id NEXT 'further questions.' ;

free_text: '(Free Text)';
numeric:'(Numeric)';
single_choice:'(Single Choice)' (NEXT '*' NEXT sentence)+;
single_choice_input:'(Single Choice with input)';
multiple_choice:'(Multiple Choice)' (NEXT '*' NEXT sentence)+;
multiple_choice_input:'(Multiple Choice with input)';
sorting_options:'(Sorting Options)' (NEXT id NEXT sentence)+;
scaling_options:'(Scaling Options)' (NEXT '*' NEXT sentence)+ NEXT 'The options are:' (NEXT id NEXT sentence)+;

text: '"' sentence (NEXT sentence)+ '"';
sentence: (word|number) (PONTUATION? NEXT (word|number))+ dot_mark;
word: LETTER+;
dot_mark: EXCLAMATION|INTERROGATION|DOT;
number: DIGIT+;

EXCLAMATION: '!' ;
INTERROGATION: '?' ;
DOT:'.';

DIGIT: [0-9];
LETTER: [A-Z]|[a-z];
PONTUATION: ',' | ':';
NEXT: [ \t\r\n]+;
//ARROWF: 'begin';
//ARROWB: 'end';

MANDATORY:'-----Mandatory';
OPTIONAL:'-----Optional';
CD:'-----Condition dependent';