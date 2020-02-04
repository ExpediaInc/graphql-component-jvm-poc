'use strict';
const fs = require('fs');
const {printSchema} = require('graphql');
const {mergeSchemas} = require('graphql-tools');
const schemaPath = './src/main/resources/schema.graphqls';

const run = async () => {
  const PropertyComponent = require('@expediagroup/property-component');
  const schemas = [];
  const component = new PropertyComponent();
  await readCurrentSchema(schemas);
  const schema = printSchema(component.schema);
  schemas.push(schema);
  const allComponentSchemasCombined = printSchema(mergeSchemas({schemas}));

  fs.writeFileSync(schemaPath, allComponentSchemasCombined,
    (err) => {
      if (err) {
        throw err;
      }
      console.log('File saved!');
    });
};

async function readCurrentSchema(schemas) {
  var contents = fs.readFileSync(schemaPath);
  if (contents) {
    schemas.push(contents.toString());
  }
};

run().catch((e) => {
  console.info(e);
  process.exit(1);
});
