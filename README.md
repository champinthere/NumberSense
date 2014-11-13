NUMBER SENSE
============


Description
------------


This is the first attempt at the LaTeX Number Sense generator. It can be used to
quickly, effectively, and, 'specifically' generate practice problems live and on
demand. Of course, it is by far still in development. Main class is GUI.java.


Platform Dependence
---------------------

As of now, this generator is highly platform dependent. Firstly, it requires a 
successful installation of pdflatex, preferably a TeXLive distribution. Next,
the shrey.number.sense.latex.Latex static method compile is currently built
only for an Apple OSX shell interpolation with LaTeX and will probably need
to be modified to work with Windows. Lastly, the constant path Strings in 
shrey.number.sense.GUI will need to be modified to suit your system and
preferred Location.

Future Goals
---------------

Firstly, more Tricks need to be created. The procedure for doing so can be
outlined as follows: 

1.  Create a class for your new Trick. You must extend class <code>Trick</code> and override the 
    <code>toL()</code> method. See the documentation of <code>toL()</code> in class <code>Trick</code> for details.
    Proper commenting is highly recommended. Look at the Tricks already
    created for reference/examples.
2.  In class <code>GUI</code>, note how Strings corresponding to class names are being 
    added to the <code>Vector\<String> text</code>. In the same format as seen in lines
    64-73 (at the time this documentation was produced) of GUI.java, add
    the name of the class extending <code>Trick</code> you created.
3.  (Optional, but recommended) Add tool-tip text for your class in the file
    Tipper.txt. Follow the format already presented.
    
I realize that this project has too many dependencies to be used easily by
the average non-technical user that will eventually by the target audience.
Therefore, a future aspiration should be to create a mannerism in which
our software can respond to server requests and send material at the request 
of the user through an interactive and user-friendly interface.

Trick List
-----------

1. Basic FOIL
2. Basic Estimation
3. Reciprocation
4. Multiplying 2 - digit with same 10's digit
5. Multiplying 2 - digit with same 10's digit with one's digits adding to 10
6. Multiplying by 3367
7. Multiplying 3 digit integers, each with digits all 3 or smaller
8. Fraction times integer in form : a * a/b 
9. Basic Conversion (under development)
10. Multiplying by 143

TODO:
-----
<ul>
    <li> Create an ordered collection of problems from 1 to 80 whoose tricks match that of the UIL release study material. </li>
    <li> Create new Tricks to match the UIL study material </li>
</ul>
Proposed Trick List for 2014 (TODO)
-----------------------------------
For the proposed set of Tricks, refer to the <a href = "sequence.pdf" target = "_blank">Trick List</a>
