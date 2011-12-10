This plugin is versioned becouse I wasn't able to get source generation
with MWE2 running without basic plugin structure.

I had to manually:
1. Generate sources by right click on root in reprotool.model.genmodel.
   Note that this step generated "wrong" source files (not concerning 
   *ImplCustom files in src folder).
2. regenerate files using reprotool.model.mwe2 file.

TODO - jvinarek - editor code should not be needed at all. I'll try
  to remove dependencies on it.    