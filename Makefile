BUILD_DIR = ./build

PRJ = playground

test:
	mill -i $(PRJ).test

verilog:
	$(call git_commit, "generate verilog")
	rm -f $(BUILD_DIR)/widsnoy_cpu.sv
	mill -i $(PRJ).runMain Elaborate --target-dir $(BUILD_DIR)
	cp $(BUILD_DIR)/* /home/widsnoy/Loongson/cdp_ede_local/mycpu_env/myCPU/

help:
	mill -i $(PRJ).runMain Elaborate --help

reformat:
	mill -i __.reformat

checkformat:
	mill -i __.checkFormat

clean:
	-rm -rf $(BUILD_DIR)

.PHONY: test verilog help reformat checkformat clean

sim:
	$(call git_commit, "sim RTL") # DO NOT REMOVE THIS LINE!!!
	@echo "Write this Makefile by yourself."

-include ../Makefile
