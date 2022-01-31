<a name="presentation"></a>

# Changelog
`documentation/changelog.txt (v4)`
This document is the official CryptoCorePack Project's changelog. Lines are added by the project's author only, based on the implemented features from 'to-do-list.txt'.  
Since this file (changelog.txt) content has already been analyzed, implemented, and tested so this file works as a read-only historical table of features and others changes.  
  
  
  
##### A preliminary note
Namely: CryptoCorePack is monitored under the project-template "Automated Kanban with reviews" on GitHub, and managed under influence of "SCRUM", therefore the project has "backlog" and, the project's development time-line is also guided by "Gitflow", so it has some branches such as "master", "develop", "release", "feature/xyz", "bugfix", "hotfix". See more about the GitHub Kanban panel of the [CryptoCorePack's project in its own page](https://github.com/users/ROPIMASI/projects/9), and see more about its [branches and time-line evolution in its own repository](https://github.com/ROPIMASI/CryptoCorePack). For a better reading know the table of [acronyms and abbreviations](https://github.com/ROPIMASI/CryptoCorePack/tree/master/documentation/acronyms-abbreviations.txt).
  
  
  
# WARNING !
### THIS DOCUMENT HAS ITS OWN RULES, WHICH MUST BE FOLLOWED SERIOUSLY !
(Because, maybe, this file will be read and interpreted by a software in the future.)  
  
  
  
### INSTRUCTIONS:
+ Inputs in this document must be done as a queue (FIFO: First In First Out Data Structure);
  - Write newlines in the above part of the tables below staying up the most recent line (see and follow date column).  
+ All columns must be filled with its related data;  
+ Any character must NOT be changed;
  - Keep unchanged presentation, warning, instructions, etc sections;
  - Keep unchanged table-title, column's top, column's bottom.  
+ RELEASE'S TYPE column must be only filled with the standard values:
  - New feature;
  - Test only;
  - Bug fix;
  - Hot fix.
+ DATE column must be only filled with the standard yyyymmdd date format:
  - Example: day 31, month January, year 2020;
    . In some countries written like that: 31/01/2020;
    . In some countries written like that: 01/31/2020;
    . Viewed like that: day day / month month / year year year year;
    . Must be write like that: year year year year / month month / day day;
    . Must be concatenated like that: yearyearyearyearmonthmonthdayday;
    . Usually contracted form like that: yyyymmdd.
+ EACH COLUMN must obey/respect its length, as marked at column's top, e.g. 8, 16, 80, 112, 128, etc.:
  - At the top and bottom of column is possible to see that from first to last character of each column are represented by dash "-", and so on, but there are some pipe "|" characters spread being a especial character as columns limiter;  
  - Inside each columns data are separated by ";" character at the end of the words, and rest of column filled with " " space character until the end of column.  
  
  
  
### SUMMARY TABLE (RELEASES):  
DATE    |RELEASE'S TYPE  |RESULTING VERSION       |BREIF CHANGE'S DESCRIPTION  
--------|----------------|------------------------|--------------------------------------------------------------------------------|  
                                                                                                                                    
Newlines will be added here... (keep this line at the top like it is now)  
20200510;Test only;       0.1.0-alpha+20200510;    First not-stable test release. Features in its detail-list, in table below.
20191120;It was born;     0.1.0-dev+20191120;      Empty.  
                                                                                                                                    
--------|----------------|------------------------|--------------------------------------------------------------------------------|  
  
  
  
### DETAILS TABLE (RELEASE'S CHAGES):  
RESULTING VERSION + MULTILINES CHANGE'S DESCRIPTION  
-128----------------------------------------------------------------------------------------------------------------------------|  
                                                                                                                                
0.1.0-alpha+20200510;  
  - Feature1: A symmetric method of cryptography using char-switching technique;
	- Name: symmCharSwitching;
  	- Interface: public static String symmCharSwitching(String aText, boolean doUndo);
  	- Behavior: obtains a new string value same size as the given string 'aText' witch has its characters switched according
  	  to the given boolean 'doUndo' where true performs the change, case false performs reverse change.
  	- Dependences:
  	  - Auxiliary method, single char switching:
  	    - Name: charSwitching;
  	    - Interface: public static char charSwitching(char c, boolean doUndo);
  	    - Behavior: obtains a new char value based on the given char 'c', it is switched according to the given boolean
  	      'doUndo' where true performs the change, case false performs reverse change.
  	    - Dependences: none.
  - Feature2: A symmetric method of cryptography using char-foundry technique, without key;
	- Name: symmRandomFoundry;
  	- Interface: public static String symmRandomFoundry(String aText, boolean doUndo);
  	- Behavior: obtains a new string value same size as the given string 'aText' witch has its characters fused with to the
  	  arbitrary character created by method, and according to boolean 'doUndo' where true performs the fusion, case false
  	  performs reverse fusion.
  	- Dependences: none.
  - Feature3: A symmetric method of cryptography using char-foundry technique, and key;
	- Name: symmKeyFoundry;
  	- Interface: public static String symmKeyFoundry(String aText, String key, boolean doUndo);
  	- Behavior: obtains a new string value same size as the given string 'aText' witch has its characters fused with to the
  	  given's key characters, and according to boolean 'doUndo' where true performs the fusion, case false performs reverse
  	  fusion.
  	- Dependences:
  	  - Auxiliary method, a simple string remolding;
  	    - Name: keyRemolding;
  	    - Interface: public static String keyRemolding(String key, int newLength);
  	    - Behavior: obtains a new string value based on the given string 'key', sizing as the given int value 'newLength' is
  	      given; 
  	    - Dependences: none.
  - Feature4: A symmetric method of cryptography using char-foundry technique, and key;
	- Name: symmKeyFoundry;
  	- Interface: public static String symmKeyFoundry(String aText, String key, boolean doUndo);
  	- Behavior: obtains a new string value same size as the given string 'aText' witch has its characters fused with to the
  	  given's key characters, and according to boolean 'doUndo' where true performs the fusion, case false performs reverse
  	  fusion.
  	- Dependences:
  	  - Auxiliary method, a simple string remolding;
  	    - Name: keyRemolding;
  	    - Interface: public static String keyRemolding(String key, int newLength);
  	    - Behavior: obtains a new string value based on the given string 'key', sizing as the given int value 'newLength' is
  	      given; 
  	    - Dependences: none.  
                                                                                                                                
-128----------------------------------------------------------------------------------------------------------------------------|  
  
  
  
######EOF.ROPIMASI.  