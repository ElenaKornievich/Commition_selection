package com.kornievich.selectionCommition.command;

import com.kornievich.selectionCommition.command.impl.common.*;

public enum CommandEnum {
    LOGIN (LoginCommand.getInstance()),
    LOGOUT (LogoutCommand.getInstance()),
    REGISTRATION(RegistrationCommand.getInstance()),
    MAIN(MainCommand.getInstance()),
    CONTACT(ContactCommand.getInstance()),
    QUEUE(QueueCommand.getInstance());

    BaseCommand command;
    CommandEnum(BaseCommand instance){
        this.command = instance;
    }
    public BaseCommand getCurrentCommand(){
        return command;
    }
}
