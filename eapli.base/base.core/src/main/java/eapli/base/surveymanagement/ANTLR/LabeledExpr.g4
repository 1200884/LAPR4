grammar LabeledExpr;
questionnaire : title NEXT id NEXT welcome_message NEXT '-----------------------------------------------------' NEXT list_of_sections final_message;
list_of_sections: section+;
section : '[' title NEXT id NEXT section_description NEXT obligatoriness NEXT content ']' NEXT #handleSection;
content: question_struct+;
question_struct : '>' id DEPENDENT? NEXT instruction NEXT type NEXT;

title:NEXT (number|word)+ #printTitle;
id: (number|word)+ PONTUATION #printId;
welcome_message: text #printExpr;
section_description: sentence;

instruction: sentence;
final_message:text;

type:repeatability;
repeatability: repeatable|non_repeatable;
repeatable:free_text|numeric|single_choice_input|multiple_choice_input|single_choice|multiple_choice;
non_repeatable:sorting_options|scaling_options;
obligatoriness: mandatory|optional|cd;

mandatory:MANDATORY;
optional:OPTIONAL;
cd:CD NEXT id id id NEXT 'further questions.' ;
option: LETTER '-'NEXT;

free_text: '(Free Text)';
numeric:'(Numeric)';
single_choice:'(Single Choice)' (NEXT option sentence)+;
single_choice_input:'(Single Choice with input)';
multiple_choice:'(Multiple Choice)' (NEXT option sentence)+;
multiple_choice_input:'(Multiple Choice with input)';
sorting_options:'(Sorting Options)' (NEXT option sentence)+;
scaling_options:'(Scaling Options)' (NEXT option sentence)+ NEXT 'The options are:' (NEXT id NEXT sentence)+;

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