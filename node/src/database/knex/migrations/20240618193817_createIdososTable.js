/**
 * @param { import("knex").Knex } knex
 * @returns { Promise<void> }
 */
exports.up = function (knex) {
    return knex.schema
        .createTable("idosos", (table) => {
            table.increments("id");
            table.integer("id_responsavel").unsigned()
            table.foreign("id_responsavel").references("id").inTable("responsaveis");
            table.string("nome", 255).notNullable();
            table.string("cpf", 255).notNullable();
            table.string("telefone", 255).notNullable();
            table.date("data_nascimento").notNullable();
            table.string("cep", 255).notNullable();
            table.string("rua", 255).notNullable();
            table.string("bairro", 255).notNullable();
            table.integer("numero").notNullable();
            table.string("complemento", 255).nullable();
            table.string("uf", 255).notNullable();
            table.string("cidade", 255).notNullable();
            table.timestamp("created_at").defaultTo(knex.fn.now());
            table.timestamp("updated_at").defaultTo(knex.fn.now());
        })
        .then(() => {
            console.log("Criado tabela de Idosos");
        });
};

/**
 * @param { import("knex").Knex } knex
 * @returns { Promise<void> }
 */
exports.down = function (knex) {
    return knex.schema.dropTable("idosos").then(() => {
        console.log("Deletado tabela de Idosos");
    });
};
