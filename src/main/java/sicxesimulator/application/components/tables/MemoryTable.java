package sicxesimulator.application.components.tables;

import sicxesimulator.application.model.data.records.MemoryEntry;

public class MemoryTable extends BaseTableView<MemoryEntry> {
    public MemoryTable() {
        super(MemoryEntry.class, "Endereço:address", "Valor:value");
    }
}