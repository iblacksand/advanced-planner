#Development Journal
John Elizarraras
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