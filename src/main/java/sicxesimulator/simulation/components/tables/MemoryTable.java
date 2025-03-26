package sicxesimulator.simulation.components.tables;

import sicxesimulator.simulation.model.data.records.MemoryEntry;

public class MemoryTable extends BaseTableView<MemoryEntry> {
    public MemoryTable() {
        super("Endereço:address", "Valor:value");
    }
}