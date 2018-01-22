package com.kornievich.selectionCommition.command;

import com.kornievich.selectionCommition.command.impl.common.LoginCommand;
import com.kornievich.selectionCommition.command.impl.common.LogoutCommand;
import com.kornievich.selectionCommition.command.impl.common.RegistrationCommand;

public enum CommandEnum {
    LOGIN (LoginCommand.getInstance()),
    LOGOUT (LogoutCommand.getInstance()),
    REGISTRATION(RegistrationCommand.getInstance());

    BaseCommand command;
    CommandEnum(BaseCommand instance){
        this.command = instance;
    }
    public BaseCommand getCurrentCommand(){
        return command;
    }
}
