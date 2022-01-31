<a name="presentation"></a>

# Versioning
`documentation/versioning.md (v6)`   
This document is the official CryptoCorePack's versioning documentation. This includes the project's versioning method and a simple historical list of released versions, in which, lines are added by the project's author only.  
  
As mentioned on `README.md` at root directory, CryptoCorePack has been developed under _SemVer_. Thus, it uses a composed of five parts VerExpr: Major.Minor.Patch-ReleaseStatus+Build (in short form M.m.p-r+b). Even it seems to be too long, but who getting involved with the project can notice that it is not, since the numbers and words used on _versioning-expression_ are small, and more importantly, the two last flags (ReleaseStatus and Build) are optional, needed in some cases. Examples: **0.1.0-beta**, **2.4.1-stable+20201005**.

&nbsp;  
&nbsp;  
&nbsp;  

## The CryptoCorePack's versioning guidelines:
  
#### Project's main assets version
Describe the version of the main assets of the project (dev.ronaldomarques.cryptocorepack package). For that it's used the VerExpr mentioned above. Its parts works as follow:
+ Major
  - It represents the main version, a number that changes according the project has developed its whole list of predefined requirements for this version in the backlog;
    - The whole list of predefined requirements intended for a specific version is called as **version-backlog**, in other words **M.m.p-backlog**, more realistic examples: **1.0.0-backlog**, or **2.0.0-backlog**, or in partial releases **1.3.0-backlog**, or **0.1.0-backlog**;
  - This part, Major, starts with value 0 (zero) meaning that the whole predefined requirements list for the first stable version (1.0.0) have not yet been accomplished, e.g. 0.1.0, or 0.2.0, 0.5.2, etc.;
  - Versioning system of this project also complies with SemVer's specifications regarding interface changes, if any interface undergoes modifications in its form of use, Major-Version must change, independently of the first Major's condition mentioned above (...has developed its whole list of predefined requirements...);
  - Once the Major version is accomplished and/or its number added 1, all other smaller parts of **VerExpr** must be reset to its initial value;
    - E.g. 1.0.0 becomes 2.0.0, or, 1.5.1 becomes 2.0.0, or, 32.19.5 becomes 33.0.0, and so on.
  - It is filled with positive integer number only: from 0 to 99 or more, who knows...
+ Minor
  - It represents a set of changes on the project's progress that are smaller than the main one, less impactful, it's a number that changes when, may be just one feature/requirement from the Main-backlog (M.0.0-backlog, e.g. 4.0.0-backlog) or, a set of them (which can be deploy-able) are implemented, the decision of when/how this number changes (it's mean what features/conditions will be accomplished to considerate a minor version done) depends mainly of the Project Manager;
  - This part starts with value 0 (zero), meaning that **NO** predefined requirements for that specific minor-version (M.0.p) have been developed, yet;
  - Once a minor-version goal is accomplished (developed, done to be merged/released) and its number added 1, all other smaller parts of VerExpr must be reset to its initial value;
    - E.g. 1.1.0 becomes 1.2.0, or, 1.5.1 becomes 1.6.0, or, 32.19.5 becomes 32.20.0, and so on.
  - It is filled with positive integer number only: from 0 to 99 or more, who knows...  
+ Patch
  - It represents a single change regardless of its size, a particular kind of change, the nature of that change is a bug-fix. Perhaps a bug-fix affects one single feature, sometimes affects more than one. In short "patch" is a number that changes along with a bug-fix merged/released to CryptoCorePack project's development time-line (Gitflow).
  - This part starts with the value 0 (zero), meaning that there were no bugs to fix yet, for example 0.1.0, or 0.2.0, or 4.11.0, etc.;
  - Once a patch-version is developed (done to be merged/released) and its number added 1, **NO others** part of VerExpr changes its values;
    - E.g. 1.1.0 becomes 1.1.1, or, 1.5.1 becomes 1.5.2 or, 32.19.5 becomes 32.19.6, and so on.
  - It is filled with positive integer number only: from 0 to 99 or more, who knows...  
+ ReleaseStatus
  - It represents the situation the development process of that version is in;
  - The standard flags of ReleaseStatus for the VerExpr are as follows:
    - **_dev_**: in early development, usage not encouraged;
	- **_alpha_**: in development, first test phase, it's encouraged usage for **test only** by people involved with software development, at self-own risk;
	- **_beta_**: in pre-release version, general public usage is acceptable, however, only for test, usage is a choice at self-own risk;
	- **_stable_**: stable tested release version; bugs are possible to appear, so it would come back to a _hotfix-branch_ if needed.
+ Build
  - Under analyzes and elaboration...
  - Lorem ipsum foo bar baz qux...  
  
#### Project's elements version (optional under analyzes and elaboration...)
Describe the version of some project's elements. Elements are small parts which make up the project's main asset, such as, records(JDK14's feature in preview), methods, classes, maybe further others. It is composed of one number preceded by 'v' character, e.g.: 'vElement', in short form 'vE', or in realistic way v0, or v1, or v5, or v32, and so on;  
+ Element
  - It represents the sequential number of times there were any change on the element's code(source, file, etc), whatever how impactful it was;
  - This part starts with the value 0 (zero), meaning that it is the first implementation, that is, there were "NO" changes on the first implementation of the element, yet;
  - Once any change happens in the element, its number is added 1;
    - E.g. v0 becomes v1, or, v1 becomes v2, or, v5 becomes v6, or v32 becomes v33, and so on;
  - It is filled with positive integer number only: from 0 to 99 or more, who knows...  
&nbsp;  
&nbsp;  
&nbsp;  
# WARNING !
### THIS DOCUMENT HAS ITS OWN RULES, WHICH MUST BE FOLLOWED SERIOUSLY !
(Because, maybe, this file will be read and interpreted by a software in the future.)  
&nbsp;  
&nbsp;  
&nbsp;  
### INSTRUCTIONS:
+ Inputs in this document must be done as a queue (FIFO: First In First Out Data Structure);
  - Write newlines in the above part of the table below (block of data) staying up the most recent line (see and follow date column).  
+ All columns must be filled with its related data;  
+ Any character must NOT be changed;
  - Keep unchanged presentation, warning, instructions, etc sections;
  - Keep unchanged table-title, column's top, column's bottom.  
+ VERSION column must be only filled with the SemVer standards values, according above explanation;  
+ DATE column must be only filled with the standard yyyymmdd date format:
  - Example: day 31, month January, year 2020;
    - In some countries written like that: 31/01/2020;
    - In some countries written like that: 01/31/2020;
    - Viewed like that: day day / month month / year year year year;
    - Must be write like that: year year year year / month month / day day;
    - Must be concatenated like that: yearyearyearyearmonthmonthdayday;
    - Usually contracted form like that: yyyymmdd.  
+ EACH COLUMN must obey/respect its length, as marked at column's top, e.g. 8, 16, 80, 112:
  - At the top and bottom of column is possible to see that from first to last character of each column are represented by dash "-", and so on, but there are some pipe "|" characters spread being a especial character as columns limiter;
  - Inside each columns data are separated by ";" character at the end of the words, and rest of column filled with " " space character until the end of column.

&nbsp;  
&nbsp;  
&nbsp;  

## HISTORYCAL TABLE:
DATE    |VERSION |RELEASE     |BUILD       |NOTE  
--------|--------|------------|------------|----------------------------------------------------------------------------------------|  
                                                                                                                                    
Newlines will be added just here below this line... (keep this line at the top like it is now)  
20200510;0.1.0;   -alpha       +20200510;   First alpha test only release: charSwitching(), symmCharSwitching(), symmKeyFusion().
20191120;0.1.0;   -dev         +20191120;   It was born, Empty project.  
                                                                                                                                    
--------|--------|------------|------------|----------------------------------------------------------------------------------------|  
  
  
  
######EOF.ROPIMASI.  
