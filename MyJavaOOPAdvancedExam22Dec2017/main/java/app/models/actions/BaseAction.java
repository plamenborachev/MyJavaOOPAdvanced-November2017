package app.models.actions;

import app.contracts.Action;
import app.contracts.Targetable;

import java.util.List;

public abstract class BaseAction implements Action {

    public abstract String executeAction(List<Targetable> participants);
}
