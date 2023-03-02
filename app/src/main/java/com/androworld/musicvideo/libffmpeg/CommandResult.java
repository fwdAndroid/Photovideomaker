package com.androworld.musicvideo.libffmpeg;

class CommandResult {
    final String output;
    final boolean success;

    CommandResult(boolean success, String output) {
        this.success = success;
        this.output = output;
    }

    static CommandResult getDummyFailureResponse() {
        return new CommandResult(false, "");
    }

    static CommandResult getOutputFromProcess(Process process) {
        String output;
        if (success(Integer.valueOf(process.exitValue()))) {
            output = Util.convertInputStreamToString(process.getInputStream());
        } else {
            output = Util.convertInputStreamToString(process.getErrorStream());
        }
        return new CommandResult(success(Integer.valueOf(process.exitValue())), output);
    }

    static boolean success(Integer exitValue) {
        return exitValue != null && exitValue.intValue() == 0;
    }
}
