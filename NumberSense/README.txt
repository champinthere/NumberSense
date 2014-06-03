
********************************************************************************
*                                DESCRIPTION                                   *
********************************************************************************

This is the first attempt at the LaTeX Number Sense generator. It can be used to
quickly, effectively, and, 'specifically' generate practice problems live and on
demand. Of course, it is by far still in development.


********************************************************************************
*                            PLATFORM DEPENDENCE                               *
********************************************************************************

As of now, this generator is highly platform dependent. Firstly, it requires a 
successful installation of pdflatex, preferably a TeXLive distribution. Next,
the shrey.number.sense.latex.Latex static method compile is currently built
only for an Apple OSX shell interpolation with LaTeX and will probably need
to be modified to work with Windows. Lastly, the constant path Strings in 
shrey.number.sense.GUI will need to be modified to suit your system and
preferred Location.

********************************************************************************
*                                 FUTURE GOALS                                 *
********************************************************************************

Firstly, more Tricks need to be created. The procedure for doing so can be
outlined as follows: 

1.  Create a class for your new Trick. You must extend Trick and override the 
    toL() method. See the documentation of toL() in class Trick for details.
    Proper commenting is highly recommended. Look at the Tricks already
    created for reference/examples.
2.  In class GUI, note how Strings corresponding to class names are being 
    added to the Vector<String> text. In the same format as seen in lines
    64-71 (at the time this documentation was produced) of GUI.java, add
    the name of the class extending Trick you created.
3.  (Optional, but recommended) Add tool-tip text for your class in the file
    Tipper.txt. Follow the format already presented.
    
I realize that this project has too many dependencies to be used easily by
the average non-technical user that will eventually by the target audience.
Therefore, a future aspiration should be to create a mannerism in which
our software can respond to server requests and send material at the request 
of the user through an interactive and user-friendly interface.

