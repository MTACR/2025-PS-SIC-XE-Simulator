module sicxesimulator {
    exports sicxesimulator.utils;
    exports sicxesimulator.hardware.cpu;
    exports sicxesimulator.hardware;
    exports sicxesimulator.hardware.data;
    exports sicxesimulator.software.macroprocessor;
    exports sicxesimulator.software.assembler;
    exports sicxesimulator.software.assembler.data; // ⬅ ADICIONE ISSO!
    exports sicxesimulator.software.data;
    exports sicxesimulator.software.linker;
    exports sicxesimulator.simulation.view to javafx.graphics;

    opens sicxesimulator.simulation.data to javafx.base;
    exports sicxesimulator.software.assembler.util;

    requires java.logging;
    requires javafx.base;
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.swing;
}
