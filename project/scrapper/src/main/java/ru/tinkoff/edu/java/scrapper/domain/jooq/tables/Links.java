/*
 * This file is generated by jOOQ.
 */
package ru.tinkoff.edu.java.scrapper.domain.jooq.tables;


import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.function.Function;

import org.jooq.Check;
import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function6;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row6;
import org.jooq.Schema;
import org.jooq.SelectField;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;

import ru.tinkoff.edu.java.scrapper.domain.jooq.Keys;
import ru.tinkoff.edu.java.scrapper.domain.jooq.Public;
import ru.tinkoff.edu.java.scrapper.domain.jooq.tables.records.LinksRecord;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Links extends TableImpl<LinksRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.links</code>
     */
    public static final Links LINKS = new Links();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<LinksRecord> getRecordType() {
        return LinksRecord.class;
    }

    /**
     * The column <code>public.links.id</code>.
     */
    public final TableField<LinksRecord, UUID> ID = createField(DSL.name("id"), SQLDataType.UUID.nullable(false).defaultValue(DSL.field("gen_random_uuid()", SQLDataType.UUID)), this, "");

    /**
     * The column <code>public.links.url</code>.
     */
    public final TableField<LinksRecord, String> URL = createField(DSL.name("url"), SQLDataType.CLOB.nullable(false), this, "");

    /**
     * The column <code>public.links.created_at</code>.
     */
    public final TableField<LinksRecord, OffsetDateTime> CREATED_AT = createField(DSL.name("created_at"), SQLDataType.TIMESTAMPWITHTIMEZONE(6).nullable(false).defaultValue(DSL.field("now()", SQLDataType.TIMESTAMPWITHTIMEZONE)), this, "");

    /**
     * The column <code>public.links.tg_chat_id</code>.
     */
    public final TableField<LinksRecord, UUID> TG_CHAT_ID = createField(DSL.name("tg_chat_id"), SQLDataType.UUID.nullable(false), this, "");

    /**
     * The column <code>public.links.github_repository_id</code>.
     */
    public final TableField<LinksRecord, UUID> GITHUB_REPOSITORY_ID = createField(DSL.name("github_repository_id"), SQLDataType.UUID, this, "");

    /**
     * The column <code>public.links.stackoverflow_question_id</code>.
     */
    public final TableField<LinksRecord, UUID> STACKOVERFLOW_QUESTION_ID = createField(DSL.name("stackoverflow_question_id"), SQLDataType.UUID, this, "");

    private Links(Name alias, Table<LinksRecord> aliased) {
        this(alias, aliased, null);
    }

    private Links(Name alias, Table<LinksRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.links</code> table reference
     */
    public Links(String alias) {
        this(DSL.name(alias), LINKS);
    }

    /**
     * Create an aliased <code>public.links</code> table reference
     */
    public Links(Name alias) {
        this(alias, LINKS);
    }

    /**
     * Create a <code>public.links</code> table reference
     */
    public Links() {
        this(DSL.name("links"), null);
    }

    public <O extends Record> Links(Table<O> child, ForeignKey<O, LinksRecord> key) {
        super(child, key, LINKS);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public UniqueKey<LinksRecord> getPrimaryKey() {
        return Keys.LINKS_PK;
    }

    @Override
    public List<UniqueKey<LinksRecord>> getUniqueKeys() {
        return Arrays.asList(Keys.UNIQUE_GITHUB_REPOSITORY_ID_TG_CHAT_ID, Keys.UNIQUE_STACKOVERFLOW_QUESTION_ID_TG_CHAT_ID);
    }

    @Override
    public List<ForeignKey<LinksRecord, ?>> getReferences() {
        return Arrays.asList(Keys.LINKS__TG_CHAT_ID_FK, Keys.LINKS__GITHUB_REPOSITORY_FK, Keys.LINKS__STACKOVERFLOW_QUESTION_FK);
    }

    private transient TgChats _tgChats;
    private transient GithubRepositories _githubRepositories;
    private transient StackoverflowQuestions _stackoverflowQuestions;

    /**
     * Get the implicit join path to the <code>public.tg_chats</code> table.
     */
    public TgChats tgChats() {
        if (_tgChats == null)
            _tgChats = new TgChats(this, Keys.LINKS__TG_CHAT_ID_FK);

        return _tgChats;
    }

    /**
     * Get the implicit join path to the <code>public.github_repositories</code>
     * table.
     */
    public GithubRepositories githubRepositories() {
        if (_githubRepositories == null)
            _githubRepositories = new GithubRepositories(this, Keys.LINKS__GITHUB_REPOSITORY_FK);

        return _githubRepositories;
    }

    /**
     * Get the implicit join path to the
     * <code>public.stackoverflow_questions</code> table.
     */
    public StackoverflowQuestions stackoverflowQuestions() {
        if (_stackoverflowQuestions == null)
            _stackoverflowQuestions = new StackoverflowQuestions(this, Keys.LINKS__STACKOVERFLOW_QUESTION_FK);

        return _stackoverflowQuestions;
    }

    @Override
    public List<Check<LinksRecord>> getChecks() {
        return Arrays.asList(
            Internal.createCheck(this, DSL.name("points_to_one_resource"), "((num_nonnulls(stackoverflow_question_id, github_repository_id) = 1))", true)
        );
    }

    @Override
    public Links as(String alias) {
        return new Links(DSL.name(alias), this);
    }

    @Override
    public Links as(Name alias) {
        return new Links(alias, this);
    }

    @Override
    public Links as(Table<?> alias) {
        return new Links(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public Links rename(String name) {
        return new Links(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Links rename(Name name) {
        return new Links(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public Links rename(Table<?> name) {
        return new Links(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row6 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row6<UUID, String, OffsetDateTime, UUID, UUID, UUID> fieldsRow() {
        return (Row6) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function6<? super UUID, ? super String, ? super OffsetDateTime, ? super UUID, ? super UUID, ? super UUID, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function6<? super UUID, ? super String, ? super OffsetDateTime, ? super UUID, ? super UUID, ? super UUID, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}
