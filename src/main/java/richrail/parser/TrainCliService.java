package richrail.parser;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import parser.RichRailLexer;
import parser.RichRailParser;

public class TrainCliService {
    public void sendCommand(String command) {
        CharStream lineStream = CharStreams.fromString(command);

        // Tokenize / Lexical analysis
        Lexer lexer = new RichRailLexer(lineStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // Create Parse Tree
        RichRailParser parser = new RichRailParser(tokens);
        ParseTree tree = parser.command();

        // Create ParseTreeWalker and Custom Listener
        ParseTreeWalker walker = new ParseTreeWalker();
        RichRailListener listener = new RichRailListener();

        // Walk over ParseTree using Custom Listener that listens to enter/exit events
        walker.walk(listener, tree);
    }
}