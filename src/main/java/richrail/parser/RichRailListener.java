package richrail.parser;

import org.antlr.v4.runtime.tree.TerminalNode;
import parser.RichRailBaseListener;
import parser.RichRailParser;
import richrail.domain.Locomotive;
import richrail.domain.Train;
import richrail.domain.Wagon;
import richrail.storage.FileStorage;

public class RichRailListener extends RichRailBaseListener {

    private FileStorage fileStorage = new FileStorage();

    @Override
    public void exitNewtraincommand(RichRailParser.NewtraincommandContext ctx) {

        fileStorage.createTrain(ctx.ID().getText());


    }

    @Override
    public void exitNewwagoncommand(RichRailParser.NewwagoncommandContext ctx) {
        fileStorage.addRollingComponent(fileStorage.findTrainByName(ctx.ID().getText()), new Wagon("A Wagon"));
    }


    @Override
    public void exitDelcommand(RichRailParser.DelcommandContext ctx) {
        fileStorage.removeTrain(fileStorage.findTrainByName(ctx.ID().getText()));

    }

    @Override
    public void exitRemcommand(RichRailParser.RemcommandContext ctx) {

        fileStorage.removeRollingComponent(fileStorage.findTrainByName(ctx.ID().getText()));



    }

    @Override
    public void enterNewlocomotivecommand(RichRailParser.NewlocomotivecommandContext ctx) {
        fileStorage.addRollingComponent(fileStorage.findTrainByName(ctx.ID().getText()), new Locomotive("A Locomotive"));

    }

}