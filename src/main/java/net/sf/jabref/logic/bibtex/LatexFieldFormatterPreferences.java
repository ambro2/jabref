package net.sf.jabref.logic.bibtex;

import java.util.Collections;
import java.util.List;

import net.sf.jabref.preferences.JabRefPreferences;

public class LatexFieldFormatterPreferences {

    private final boolean resolveStringsAllFields;
    private final List<String> doNotResolveStringsFor;
    private final int lineLength;
    private final FieldContentParserPreferences fieldContentParserPreferences;


    public LatexFieldFormatterPreferences(boolean resolveStringsAllFields, List<String> doNotResolveStringsFor,
            int lineLength,
            FieldContentParserPreferences fieldContentParserPreferences) {
        this.resolveStringsAllFields = resolveStringsAllFields;
        this.doNotResolveStringsFor = doNotResolveStringsFor;
        this.lineLength = lineLength;
        this.fieldContentParserPreferences = fieldContentParserPreferences;
    }

    public LatexFieldFormatterPreferences() {
        // This constructor is only to allow an empty constructor in SavePreferences
        this(true, Collections.emptyList(), 0, new FieldContentParserPreferences());
    }

    public static LatexFieldFormatterPreferences fromPreferences(JabRefPreferences prefs) {
        return new LatexFieldFormatterPreferences(prefs.getBoolean(JabRefPreferences.RESOLVE_STRINGS_ALL_FIELDS),
                prefs.getStringList(JabRefPreferences.DO_NOT_RESOLVE_STRINGS_FOR),
                prefs.getInt(JabRefPreferences.LINE_LENGTH), FieldContentParserPreferences.fromPreferences(prefs));
    }

    public boolean isResolveStringsAllFields() {
        return resolveStringsAllFields;
    }

    public List<String> getDoNotResolveStringsFor() {
        return doNotResolveStringsFor;
    }

    public int getLineLength() {
        return lineLength;
    }

    public FieldContentParserPreferences getFieldContentParserPreferences() {
        return fieldContentParserPreferences;
    }
}
