#Development Journal
John Elizarraras

[Latest Journal Entry](#journal-entry-for-the-week-of-mar-19---mar-29)

## Journal entry for the week of Jan 22 - 29

 During this week I finished the proposal file and started to think on ideas for commands. I thought about adding 'ask' and 'answer' subsets of the display function of which can be used as following:

 'display.ask what is your favorite color?'

 'display.answer.prop(cs) blue'

 It would display "what is your favorite color?" and ask for user input. It would only accept the answer blue, which is case sensitive, before moving on in the script.
 I also have been working the .prop(string property) which allows for special properties to the command. I think this will be the most useful in the display command but could be used for auto-closing the program that was run, or a loop that ends if a step is not completed. This would be hard to compile but I think I could do it. I have thought of these tags so far:

 'cs' - case-sensitive

 'ac' - auto-closes whatever is attached after time limit

 'f' - 'fragile' - breaks this if anything above it fails.

 These are the ideas I have so far. Hopefully I am able to add these since they would add a lot of functionality to the program.

---
 Word Count: [193](http://i.imgur.com/756ynTj.png)

## Journal entry for the week of Jan 30 - Feb 5
During this week I got Script.java to be 'complete'. It can read the file and sort everything out. The only thing needed to be worked on it is to add all of the properties that I add. I also worked on AdvancedPlanner.java and got the skeleton of run and loop. I have to wait for the GUI to work in order for display to work. I also have been thinking about the .answer tag from above. I will probably make it a property and not a separate thing. I also added some testers that will help the debugging part. I also added Javadoc to all of the methods. I will start working on the compiler so that way I don't have to cram everything in two weeks. I also added a example.txt file that shows what a script could look like. I plan to test loop and hopefully I will be able to finish this in the next two weeks.

---
 Word Count: [160](http://i.imgur.com/Wc2BFM8.png)
 
## Journal entry for the week of Feb 6 - Feb 14
During this week I finally got to AdvancedPlanner to run a program. I also started to work on the FileEditor, which will be used to edit the current Script on the fly, in order to fix errors. It still has some errors in the insert and add methods but it currently is working fine. I want to create more commands because it currently doesn't have much function. I am going to start the testing, which has been started in the tester package. I already fixed errors in Script in respect to out of index errors. There is one error with loops where it will keep looping forever which I am currently looking into. One thing I am working on is the actually planning of more commands. I am thinking of adding something that can be used to time something with a Master timer, with small timers inside of it. I think that would be a good addition to improve productivity.

---
 Word Count : [160](http://i.imgur.com/uPOKlmi.png)

## Journal Entry for the week of Feb 15 - Feb 19
During this week I changed the deliverables, which are highlighted in bold in the proposal. I also added support for case-sensitive inputs, by making it not make everything to lower case. I also added the [FileEditor.java](https://github.com/iblacksand/advanced-planner/blob/master/file/FileEditor.java) which will allow on the fly script editing. I also started to work on the loop class, since it was running forever into negative infinity. I made the FileEditor be able to insert, set or add a line at any index, as long as it won't cause any errors. I have started to think about how the compiler will work, with booleans to keep track of errors. I also started to create a new class called [CompileError](https://github.com/iblacksand/advanced-planner/blob/master/compile/CompileError.java) which will keep track of all of the errors in the compiler with the linenumber that is is on. I also am testing the loop method and it is looking promising. I think that everything will be complete as the deliverables say they will.

---
 Word Count : [157](http://i.imgur.com/o6kbG9Z.png)

## Journal Entry for the week of Feb 20 - Feb 28
During this week I was able to complete all of the deliverables. The biggest accomplishment for this week, for me was the loop() method in [AdvancedPlanner.java](https://github.com/iblacksand/advanced-planner/blob/master/main/AdvancedPlanner.java). The only thing that needs to be worked on the loop method is to have the pauses specified which was not part of the deliverable, since it was only for base commands. I will be adding a TUTORIAL.md to help explain how to use it (since the readme is more for links, apparently) but it shouldn't be too hard if you look in the example.txt. Another part that I did this week was test for exceptions and I couldn't find any. I also created [DELIVERABLES.md](https://github.com/iblacksand/advanced-planner/blob/master/DELIVERABLES.md) which will help keep track of all of the deliverables that I completed. All of the Javadoc has been created in [/doc](https://github.com/iblacksand/advanced-planner/tree/master/doc) if you want to see what each method does. Overall this week has been productive and completes everything that was asked.

---
 Word Count : [154](http://i.imgur.com/vrvm57A.png)
 
## Journal Entry for the week of Feb 29 - Mar 6
During this week I added a toString method to [CompileError.java](https://github.com/iblacksand/advanced-planner/blob/master/compile/CompileError.java) to show the line number and the error message. I also finished [Compiler.java](https://github.com/iblacksand/advanced-planner/blob/master/compile/Compiler.java), in the respect that it can compile the run, start and loop commands I also tried to get loop to run correctly but I can only make it pause once. I also started to work on getting the basics of the gui down. I was able to make a window with a button and a label in [GuiWindow.java](https://github.com/iblacksand/advanced-planner/blob/master/gui/GuiWindow.java). I also created a popup window in [GuiPopup](https://github.com/iblacksand/advanced-planner/blob/master/gui/GuiPopup.java) in hopes for when the main window closed it would popup with a simple JLabel, but it won't show unless I use the tester from [GuiPopupTester.java](https://github.com/iblacksand/advanced-planner/blob/master/tester/GuiPopupTester.java). This is what I want to fix this week since it is the last part of these deliverables. I also plan to get the loop to pause for the correct amount of time because it seems simple. The last part of the thing I need to do is to test the compiler to make sure that errors don't go past it.

---
 Word Count : [176](http://i.imgur.com/ZdTUlUh.png)

## Journal Entry for the week of Mar 7 - Mar 13
During this week I started to put everything into the deliverables and I am trying to start making display make a window popup with the specified text with you use the display command. I will also create a file to make it easier for the gui to create entries into. I also updated [Proposal.md](https://github.com/iblacksand/advanced-planner/blob/master/PROPOSAL.md) to include all of the changes that were finished. I also updated [DELIVERABLES](https://github.com/iblacksand/advanced-planner/blob/master/DELIVERABLES.md) to show all of the progress that I made. I wasn't able to work too much on the actual gui but I was able to see how swing worked. I also made finsihed all of the development journals for the deliverables. I also created [GuiForm.java](https://github.com/iblacksand/advanced-planner/blob/master/gui/GuiForm.java), which is for testing the way Intellij works in respect to gui's and if there is a way to do it easier than what it is now. 

---
 Word Count : [139](http://i.imgur.com/aXuskDG.png)
 
## Journal Entry for the week of Mar 14 - Mar 18
During this week I started to work on making the program work in a basic way. It "works" in the sense that all of the commands work except for the properties which is a deliverable I will add for the next deliverable cycle. I made the Script just not add properties that don't exist so the compiler won't need to handle it. I also started to make a tutorial that is available on the projects [GitHub Page](http://iblacksand.github.io/advanced-planner/). There is also, I think, more readable versions of this, and all of the other .md files on the website. I will give credit to [Strapdown.js](http://strapdownjs.com/) for creating the tool that I used to create the webpage. The final things left for me to do for the deliverables is to have the alias support and changing the script maker to extend to application, not jFrame to make it look nicer.

---

 Word Count : [149](http://i.imgur.com/aabnOFh.png)

 ## Journal Entry for the week of Mar 19 - Mar 29
 During this week I finished all of the deliverables for this week which you can see in [DELIVERABLES.md](https://github.com/iblacksand/advanced-planner/blob/master/DELIVERABLES.md). I finished the compiler to work with the gui, which works. The only problem I have with loop is that it only pauses once, and loops through immediatly. I could do Thread.sleep(int x), but this makes the window freeze. Another issue I have is that when I press the exit button on the gui, the advanced planner still goes. Also I am keeping track of [iblacksand.github.io](http://iblacksand.github.io/), so you can trust everything on there. I also made the script builder, although it is simple, it gets the job done. I also got aliases to start. The last parts of the project to be done is pausing and the properties. I also released [v.15](https://github.com/iblacksand/advanced-planner/releases/tag/v0.15), which is something that you can use. Although it can be hard, you can see a tutorial for it [here](http://iblacksand.github.io/advanced-planner/Tutorial.html). There is a list of commands [here](http://iblacksand.github.io/advanced-planner/Commands.html). You can do basic stuff except for aliases and properties.

 ---

  Word Count : [167](http://i.imgur.com/e4tLpHV.png)